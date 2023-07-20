# CMakeLists.txt
#
# Wireshark - Network traffic analyzer
# By Gerald Combs <gerald@wireshark.org>
# Copyright 1998 Gerald Combs
#
# SPDX-License-Identifier: GPL-2.0-or-later
#

project(Wireshark C CXX)

# Updated by make-version.pl
set(GIT_REVISION 0)
set(PROJECT_MAJOR_VERSION 2)
set(PROJECT_MINOR_VERSION 6)
set(PROJECT_PATCH_VERSION 20)
set(PROJECT_BUILD_VERSION ${GIT_REVISION})
set(PROJECT_VERSION_EXTENSION "")
set(PROJECT_RELEASE_VERSION "${PROJECT_MAJOR_VERSION}.${PROJECT_MINOR_VERSION}")

if(DEFINED ENV{WIRESHARK_VERSION_EXTRA})
	set(PROJECT_VERSION_EXTENSION "$ENV{WIRESHARK_VERSION_EXTRA}")
endif()

set(PROJECT_VERSION "${PROJECT_MAJOR_VERSION}.${PROJECT_MINOR_VERSION}.${PROJECT_PATCH_VERSION}${PROJECT_VERSION_EXTENSION}")

# packaging information
if(WIN32)
        set(CPACK_PACKAGE_NAME Wireshark)
else()
        set(CPACK_PACKAGE_NAME wireshark)
endif()

set(CPACK_PACKAGE_VERSION "${PROJECT_VERSION}")

# These are required in .rc files and manifests
set(VERSION_MAJOR ${PROJECT_MAJOR_VERSION})
set(VERSION_MINOR ${PROJECT_MINOR_VERSION})
set(VERSION_MICRO ${PROJECT_PATCH_VERSION})
set(VERSION_BUILD ${PROJECT_BUILD_VERSION})
set(RC_VERSION ${PROJECT_MAJOR_VERSION},${PROJECT_MINOR_VERSION},${PROJECT_PATCH_VERSION},${PROJECT_BUILD_VERSION})

message(STATUS "V: ${PROJECT_VERSION}, MaV: ${PROJECT_MAJOR_VERSION}, MiV: ${PROJECT_MINOR_VERSION}, PL: ${PROJECT_PATCH_VERSION}, EV: ${PROJECT_VERSION_EXTENSION}.")

include(UseLemon)
include(UseMakePluginReg)
include(UseMakeTaps)
include(UseAsn2Wrs)


set( C_FLAG_TESTS ${WIRESHARK_COMMON_FLAGS} ${WIRESHARK_C_ONLY_FLAGS} )
set( CXX_FLAG_TESTS ${WIRESHARK_COMMON_FLAGS} ${WIRESHARK_CXX_ONLY_FLAGS} )

set( C_WARN_TESTS ${COMMON_WARN_FLAGS} ${C_WARN_FLAGS} )
set( CXX_WARN_TESTS ${COMMON_WARN_FLAGS} ${CXX_WARN_FLAGS} )

# Counterhack to work around some cache magic in CHECK_C_SOURCE_COMPILES
include(CheckCCompilerFlag)
include(CheckCXXCompilerFlag)

if(ENABLE_STATIC)
	set(BUILD_SHARED_LIBS 0)
else()
	set(BUILD_SHARED_LIBS 1)
endif()

if(APPLE)
	#
	# We assume that APPLE means macOS so that we have the macOS
	# frameworks.
	#
	set(HAVE_MACOS_FRAMEWORKS 1)
	FIND_LIBRARY (APPLE_APPKIT_LIBRARY pthread)
endif()

# C Asynchronous resolver
if(ENABLE_CARES)
	set(PACKAGELIST ${PACKAGELIST} CARES)
	# Minimum version needed.
	set(CARES_OPTIONS "1.5.0")
endif()

if (NOT "${SHELLCHECK_EXECUTABLE}" STREQUAL "SHELLCHECK_EXECUTABLE-NOTFOUND")
	add_custom_target(shellcheck)
	set_target_properties(shellcheck PROPERTIES FOLDER "Tests")
	# --external-sources requires 0.4.0 or later.
	add_custom_command(TARGET shellcheck POST_BUILD
		COMMAND shellcheck --external-sources
			tools/fuzz-test.sh
			tools/randpkt-test.sh
			tools/test-captures.sh
			tools/valgrind-wireshark.sh
		WORKING_DIRECTORY "${CMAKE_SOURCE_DIR}"
	)
endif()

