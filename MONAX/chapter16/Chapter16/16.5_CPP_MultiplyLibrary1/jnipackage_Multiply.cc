#include "jnipackage_Multiply.h"

JNIEXPORT jdouble JNICALL Java_example_Multiply_getProduct__DD
  (JNIEnv * env, jclass cls, jdouble a, jdouble b)
{
	return a*b;
}



