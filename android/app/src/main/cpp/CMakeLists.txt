cmake_minimum_required(VERSION 3.22.1)
project(local_ai LANGUAGES C CXX)

set(CMAKE_C_STANDARD 11)
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

set(LLAMA_SRC "${CMAKE_CURRENT_LIST_DIR}/../../../../vendor/llama.cpp")
if(NOT EXISTS "${LLAMA_SRC}/CMakeLists.txt")
    message(FATAL_ERROR "llama.cpp is missing. Run: bash scripts/android-bootstrap.sh")
endif()

add_subdirectory("${LLAMA_SRC}" "${CMAKE_CURRENT_BINARY_DIR}/llama" EXCLUDE_FROM_ALL)

add_library(local-ai SHARED native_engine.cpp)
target_include_directories(local-ai PRIVATE
    "${LLAMA_SRC}"
    "${LLAMA_SRC}/common"
    "${LLAMA_SRC}/include"
    "${LLAMA_SRC}/ggml/include")
target_link_libraries(local-ai PRIVATE llama llama-common android log)
target_link_options(local-ai PRIVATE "-Wl,--gc-sections" "-Wl,--exclude-libs,ALL")
