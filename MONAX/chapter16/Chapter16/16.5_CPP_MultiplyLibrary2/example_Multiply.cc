#include "example_Multiply.h"

JNIEXPORT jdouble JNICALL Java_example_Multiply_getProduct__DD(JNIEnv * env, jclass cls, jdouble a, jdouble b) {
    return a*b;
}


//This method copies contents of 2D java array into C++ buffer in row-by-row order
void jMatrix2cMatrix(JNIEnv * env, jobjectArray jM, int r, int c, double* M) {
    double* X = M;
    for (int i = 0;i < r;i++) {
        jdoubleArray jrow = reinterpret_cast<jdoubleArray>(env->GetObjectArrayElement(jM, i));
        env->GetDoubleArrayRegion(jrow, 0, c, X);
        X+=c;
    }
}


//This method creates java 2D array of size [r x c] and copies
//data form C++ buffer into this array
jobjectArray cMatrix2jMatrix(JNIEnv * env, double* C, int rows, int cols) {
    jdoubleArray row = env->NewDoubleArray(cols);
    jclass cls = env->GetObjectClass(row);
    jobjectArray jC = (jobjectArray)env->NewObjectArray(rows, cls, row);
    for (int i = 0;i < rows;i++) {
        row = env->NewDoubleArray(cols);
        env->SetDoubleArrayRegion(row, 0, cols, C);
        env->SetObjectArrayElement(jC, i, row);
        C += cols;
    }
    
    return jC;
}


JNIEXPORT jobjectArray JNICALL Java_example_Multiply_getProduct___3_3D_3_3D(JNIEnv * env, jclass cls, jobjectArray jA, jobjectArray jB) {
//Determining array length and checking if multiplication
//for supplied matrices is allowed
//In Java 2D arrays are organized as arrays of arrays
//So each matrix is jobjectArray, each element of it contains jdoubleArray
    
//Rows in matrix A
    int rowsA = env->GetArrayLength(jA);
    if (rowsA < 1) return NULL;
    
//Columns in matrix A
    jdoubleArray jrow = reinterpret_cast<jdoubleArray>(env->GetObjectArrayElement(jA, 0));
    int colsA = env->GetArrayLength(jrow);
    if (colsA < 1) return NULL;
    
//Rows in matrix B
    int rowsB = env->GetArrayLength(jB);
    if (rowsB < 1) return NULL;
    
//Columns in matrix B
    jrow = reinterpret_cast<jdoubleArray>(
            env->GetObjectArrayElement(jB, 0));
    int colsB = env->GetArrayLength(jrow);
    if (colsB < 1) return NULL;
    
//Multiplication is not allows
    if (colsA != rowsB) return NULL;
    
//Without optimization we have to copy input matrices into
//C++ memory buffer to ensure that data is contiguous in memory
    
    double* A = new double[rowsA*colsA];
    jMatrix2cMatrix(env, jA, rowsA, colsA, A);
    double* B = new double[rowsB*colsB];
    jMatrix2cMatrix(env, jB, rowsB, colsB, B);
    double* C = new double[rowsA*colsB];
    
//Performing actual multiplication
    for (int i = 0;i < rowsA;i++){
        for (int j = 0;j < colsB;j++) {
            double d = 0;
            for (int k = 0;k < colsA;k++)
                d += A[i*colsA + k]*B[k*colsB + j];
            C[i*colsB + j] = d;
        }
    }
    jobjectArray jC = cMatrix2jMatrix(env, C, rowsA, colsB);
    
    delete []A;
    delete []B;
    delete []C;
    
    return jC;
}
