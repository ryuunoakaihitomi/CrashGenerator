#include <jni.h>

using namespace std;
extern "C"
JNIEXPORT void JNICALL
Java_ryuunoakaihitomi_crashgenerator_MainActivity_nativeCrash(JNIEnv *, jobject) {
    int *pInt = NULL;
    //write into a null pointer.
    *pInt = 1;
}