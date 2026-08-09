using UnityEngine;

namespace HeroesLore
{
    public class GamepadInput : MonoBehaviour
    {
        public float Dx { get; private set; }
        public float Dy { get; private set; }
        public bool AttackPressed { get; private set; }
        public bool SkillPressed { get; private set; }
        public bool MenuPressed { get; private set; }
        public bool ConfirmPressed { get; private set; }
        public bool CancelPressed { get; private set; }

        private bool prevStart, prevSouth, prevEast, prevWest, prevNorth;

        void Update()
        {
            Dx = 0; Dy = 0;
            AttackPressed = false; SkillPressed = false;
            MenuPressed = false; ConfirmPressed = false; CancelPressed = false;

            if (Input.GetJoystickNames().Length == 0) return;

            // D-pad / Left stick
            Dx = Input.GetAxis("Horizontal");
            Dy = Input.GetAxis("Vertical");
            if (Mathf.Abs(Dx) < 0.2f) Dx = 0;
            if (Mathf.Abs(Dy) < 0.2f) Dy = 0;

            // Also read D-pad buttons directly
            try
            {
                if (Input.GetKey(KeyCode.JoystickButton15)) Dx = -1f; // D-pad left
                if (Input.GetKey(KeyCode.JoystickButton14)) Dx = 1f;  // D-pad right
                if (Input.GetKey(KeyCode.JoystickButton12)) Dy = 1f;  // D-pad up
                if (Input.GetKey(KeyCode.JoystickButton13)) Dy = -1f; // D-pad down
            }
            catch { }

            // South button (A/Cross) = Attack
            bool south = Input.GetKey(KeyCode.JoystickButton0);
            if (south && !prevSouth) AttackPressed = true;
            prevSouth = south;

            // East button (B/Circle) = Skill  
            bool east = Input.GetKey(KeyCode.JoystickButton1);
            if (east && !prevEast) SkillPressed = true;
            prevEast = east;

            // West button (X/Square) = Cancel
            bool west = Input.GetKey(KeyCode.JoystickButton2);
            if (west && !prevWest) CancelPressed = true;
            prevWest = west;

            // North button (Y/Triangle) = Confirm
            bool north = Input.GetKey(KeyCode.JoystickButton3);
            if (north && !prevNorth) ConfirmPressed = true;
            prevNorth = north;

            // Start = Menu
            bool start = Input.GetKey(KeyCode.JoystickButton9);
            if (start && !prevStart) MenuPressed = true;
            prevStart = start;

            // Back/Select = Cancel
            if (Input.GetKeyDown(KeyCode.JoystickButton8)) CancelPressed = true;

            // L1/R1 for inventory
            if (Input.GetKeyDown(KeyCode.JoystickButton4) || Input.GetKeyDown(KeyCode.JoystickButton5))
                MenuPressed = true;
        }
    }
}