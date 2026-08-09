using UnityEngine;
using UnityEngine.UI;
using UnityEngine.EventSystems;

namespace HeroesLore
{
    public class VirtualDPad : MonoBehaviour
    {
        public Vector2 Direction { get; private set; }
        public bool AttackPressed { get; set; }
        public bool SkillPressed { get; set; }
        public bool MenuPressed { get; set; }
        public bool ConfirmPressed { get; set; }
        public bool CancelPressed { get; set; }
        public bool Visible { get; set; } = true;

        Transform dpadRoot;
        Image bgDpad;
        Image knob;
        RectTransform knobRect;
        Image btnAttackImg, btnSkillImg, btnMenuImg;
        Button btnAttack, btnSkill, btnMenu;
        RectTransform bgRect;
        float dpadRadius = 50f;
        float knobRadius = 20f;
        int touchId = -1;
        Vector2 dpadCenter;
        float canvasScale = 1f;

        public void Init(Transform canvasT, float w, float h)
        {
            canvasScale = 1f;
            dpadCenter = new Vector2(90, h - 90);

            // D-pad background
            dpadRoot = new GameObject("DpadRoot");
            dpadRoot.SetParent(canvasT);
            var rt = dpadRoot.AddComponent<RectTransform>();
            rt.anchorMin = Vector2.zero; rt.anchorMax = Vector2.one;
            rt.sizeDelta = Vector2.zero;

            bgDpad = CreateUIImage(dpadRoot, new Vector2(dpadCenter.x, dpadCenter.y),
                new Vector2(dpadRadius * 2, dpadRadius * 2), new Color(1, 1, 1, 0.15f));
            bgRect = bgDpad.rectTransform;

            // Knob
            knob = CreateUIImage(dpadRoot, dpadCenter,
                new Vector2(knobRadius * 2, knobRadius * 2), new Color(1, 1, 1, 0.4f));
            knobRect = knob.rectTransform;

            // Buttons
            Vector2 atkPos = new Vector2(w - 80, h - 130);
            Vector2 sklPos = new Vector2(w - 140, h - 90);
            Vector2 menuPos = new Vector2(w - 50, h - 60);

            btnAttackImg = CreateUIImage(dpadRoot, atkPos, new Vector2(56, 56), new Color(1f, 0.3f, 0.3f, 0.5f));
            btnAttack = btnAttackImg.gameObject.AddComponent<Button>();
            btnAttack.targetGraphic = btnAttackImg;
            var atkTxt = CreateUIText(btnAttackImg.gameObject, "A", 20, Color.white);
            atkTxt.rectTransform.anchorMin = atkTxt.rectTransform.anchorMax = Vector2.zero;
            atkTxt.rectTransform.anchoredPosition = Vector2.zero;
            btnAttack.onClick.AddListener(() => { AttackPressed = true; });

            btnSkillImg = CreateUIImage(dpadRoot, sklPos, new Vector2(56, 56), new Color(0.3f, 0.3f, 1f, 0.5f));
            btnSkill = btnSkillImg.gameObject.AddComponent<Button>();
            btnSkill.targetGraphic = btnSkillImg;
            var sklTxt = CreateUIText(btnSkillImg.gameObject, "B", 20, Color.white);
            sklTxt.rectTransform.anchorMin = sklTxt.rectTransform.anchorMax = Vector2.zero;
            sklTxt.rectTransform.anchoredPosition = Vector2.zero;
            btnSkill.onClick.AddListener(() => { SkillPressed = true; });

            btnMenuImg = CreateUIImage(dpadRoot, menuPos, new Vector2(44, 44), new Color(0.3f, 1f, 0.3f, 0.5f));
            btnMenu = btnMenuImg.gameObject.AddComponent<Button>();
            btnMenu.targetGraphic = btnMenuImg;
            var mTxt = CreateUIText(btnMenuImg.gameObject, "M", 16, Color.white);
            mTxt.rectTransform.anchorMin = mTxt.rectTransform.anchorMax = Vector2.zero;
            mTxt.rectTransform.anchoredPosition = Vector2.zero;
            btnMenu.onClick.AddListener(() => { MenuPressed = true; });

            dpadRoot.gameObject.SetActive(false);
        }

        Image CreateUIImage(Transform parent, Vector2 pos, Vector2 size, Color color)
        {
            var go = new GameObject("UI");
            go.transform.SetParent(parent);
            var rt = go.AddComponent<RectTransform>();
            rt.pivot = new Vector2(0.5f, 0.5f);
            rt.anchorMin = Vector2.zero; rt.anchorMax = Vector2.one;
            rt.anchoredPosition = pos;
            rt.sizeDelta = size;
            var img = go.AddComponent<Image>();
            img.color = color;
            return img;
        }

        Text CreateUIText(GameObject parent, string text, int size, Color color)
        {
            var go = new GameObject("Txt");
            go.transform.SetParent(parent.transform);
            var rt = go.AddComponent<RectTransform>();
            rt.sizeDelta = new Vector2(40, 40);
            var txt = go.AddComponent<Text>();
            txt.text = text;
            txt.fontSize = size;
            txt.fontStyle = FontStyle.Bold;
            txt.color = color;
            txt.alignment = TextAnchor.MiddleCenter;
            txt.font = Resources.GetBuiltinResource<Font>("Arial.ttf");
            return txt;
        }

        void Update()
        {
            dpadRoot.gameObject.SetActive(Visible);
            if (!Visible) { Direction = Vector2.zero; return; }

            // Handle touch D-pad
            Direction = Vector2.zero;
            bool anyTouch = false;

            for (int i = 0; i < Input.touchCount; i++)
            {
                var t = Input.GetTouch(i);
                Vector2 tpos = t.position;

                // Check if touch is on D-pad area
                float dist = Vector2.Distance(tpos, dpadCenter);
                if (dist < dpadRadius * 2f)
                {
                    anyTouch = true;
                    if (t.phase == TouchPhase.Began || t.phase == TouchPhase.Moved || t.phase == TouchPhase.Stationary)
                    {
                        Vector2 delta = tpos - dpadCenter;
                        if (delta.magnitude > 5f)
                        {
                            Direction = delta.normalized;
                            Vector2 knobPos = dpadCenter + Direction * Mathf.Min(delta.magnitude, dpadRadius);
                            knobRect.anchoredPosition = knobPos;
                        }
                        else
                        {
                            knobRect.anchoredPosition = dpadCenter;
                        }
                    }
                    if (t.phase == TouchPhase.Ended || t.phase == TouchPhase.Canceled)
                    {
                        knobRect.anchoredPosition = dpadCenter;
                    }
                }
            }

            // Also support tap anywhere for confirm (title/class screens)
            if (Input.touchCount > 0)
            {
                var t = Input.GetTouch(0);
                if (t.phase == TouchPhase.Began)
                {
                    // Check if not on D-pad or buttons
                    float distDpad = Vector2.Distance(t.position, dpadCenter);
                    if (distDpad > dpadRadius * 2.5f)
                    {
                        ConfirmPressed = true;
                    }
                }
            }

            // Keyboard fallback (for testing)
            float kx = 0, ky = 0;
            if (Input.GetKey(KeyCode.LeftArrow) || Input.GetKey(KeyCode.A)) kx = -1;
            if (Input.GetKey(KeyCode.RightArrow) || Input.GetKey(KeyCode.D)) kx = 1;
            if (Input.GetKey(KeyCode.UpArrow) || Input.GetKey(KeyCode.W)) ky = 1;
            if (Input.GetKey(KeyCode.DownArrow) || Input.GetKey(KeyCode.S)) ky = -1;
            if (kx != 0 || ky != 0)
            {
                Vector2 kdir = new Vector2(kx, ky).normalized;
                Direction = kdir;
            }
            if (Input.GetKeyDown(KeyCode.Space)) AttackPressed = true;
            if (Input.GetKeyDown(KeyCode.B)) SkillPressed = true;
            if (Input.GetKeyDown(KeyCode.Escape) || Input.GetKeyDown(KeyCode.M)) MenuPressed = true;
            if (Input.GetKeyDown(KeyCode.Return)) ConfirmPressed = true;
            if (Input.GetKeyDown(KeyCode.X)) CancelPressed = true;
            if (Input.GetKeyDown(KeyCode.I)) MenuPressed = true;
        }
    }
}