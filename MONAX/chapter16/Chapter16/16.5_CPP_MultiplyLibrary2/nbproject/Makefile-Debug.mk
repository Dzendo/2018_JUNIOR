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
OBJECTDIR=build/Debug/MinGW-Windows

# Object Files
OBJECTFILES= \
	${OBJECTDIR}/example_Multiply.o

# C Compiler Flags
CFLAGS=

# CC Compiler Flags
CCFLAGS=
CXXFLAGS=

# Fortran Compiler Flags
FFLAGS=

# Link Libraries and Options
LDLIBSOPTIONS=

# Build Targets
.build-conf: ${BUILD_SUBPROJECTS} dist/Debug/MinGW-Windows/lib16.5_CPP_MultiplyLibrary2.dll

dist/Debug/MinGW-Windows/lib16.5_CPP_MultiplyLibrary2.dll: ${OBJECTFILES}
	${MKDIR} -p dist/Debug/MinGW-Windows
	${LINK.cc} -shared -o dist/Debug/MinGW-Windows/lib16.5_CPP_MultiplyLibrary2.dll -fPIC ${OBJECTFILES} ${LDLIBSOPTIONS} 

${OBJECTDIR}/example_Multiply.o: example_Multiply.cc 
	${MKDIR} -p ${OBJECTDIR}
	$(COMPILE.cc) -g -ID\:/Util/Java/jdk1.6.0_03/include -ID\:/Util/Java/jdk1.6.0_03/include/win32 -fPIC  -o ${OBJECTDIR}/example_Multiply.o example_Multiply.cc

# Subprojects
.build-subprojects:

# Clean Targets
.clean-conf:
	${RM} -r build/Debug
	${RM} dist/Debug/MinGW-Windows/lib16.5_CPP_MultiplyLibrary2.dll

# Subprojects
.clean-subprojects:
