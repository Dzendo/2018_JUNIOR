#
# Gererated Makefile - do not edit!
#
# Edit the Makefile in the project folder instead (../Makefile). Each target
# has a -pre and a -post target defined where you can add customized code.
#
# This makefile implements configuration specific macros and targets.


# Environment
MKDIR=mkdir
CP=cp
CCADMIN=CCadmin
RANLIB=ranlib
CC=gcc.exe
CCC=g++.exe
CXX=g++.exe
FC=

# Include project Makefile
include Makefile

# Object Directory
OBJECTDIR=build/Release/MinGW-Windows

# Object Files
OBJECTFILES= \
	${OBJECTDIR}/jnipackage_Multiply.o

# C Compiler Flags
CFLAGS=

# CC Compiler Flags
CCFLAGS=-m32
CXXFLAGS=-m32

# Fortran Compiler Flags
FFLAGS=

# Link Libraries and Options
LDLIBSOPTIONS=

# Build Targets
.build-conf: ${BUILD_SUBPROJECTS} dist/Release/MinGW-Windows/CPP_MultiplyLibrary.dll

dist/Release/MinGW-Windows/CPP_MultiplyLibrary.dll: ${OBJECTFILES}
	${MKDIR} -p dist/Release/MinGW-Windows
	${LINK.cc} -shared -o dist/Release/MinGW-Windows/CPP_MultiplyLibrary.dll -fPIC ${OBJECTFILES} ${LDLIBSOPTIONS} 

${OBJECTDIR}/jnipackage_Multiply.o: jnipackage_Multiply.cc 
	${MKDIR} -p ${OBJECTDIR}
	$(COMPILE.cc) -O2 -Wall -IC\:/_Util/MinGW/include -IC\:/_Util/MinGW/include/c++/3.4.2/backward -IC\:/_Util/MinGW/include/c++/3.4.2 -IC\:/_Util/MinGW/lib/gcc/mingw32/3.4.2 -IC\:/_Util/MinGW/lib/gcc/mingw32/3.4.2/include -IC\:/_Util/jdk1.6.0_02/include -IC\:/_Util/jdk1.6.0_02/include/win32 -fPIC  -o ${OBJECTDIR}/jnipackage_Multiply.o jnipackage_Multiply.cc

# Subprojects
.build-subprojects:

# Clean Targets
.clean-conf:
	${RM} -r build/Release
	${RM} dist/Release/MinGW-Windows/CPP_MultiplyLibrary.dll

# Subprojects
.clean-subprojects:
