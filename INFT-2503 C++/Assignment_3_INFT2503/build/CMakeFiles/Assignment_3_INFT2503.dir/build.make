# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.28

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:

#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:

# Disable VCS-based implicit rules.
% : %,v

# Disable VCS-based implicit rules.
% : RCS/%

# Disable VCS-based implicit rules.
% : RCS/%,v

# Disable VCS-based implicit rules.
% : SCCS/s.%

# Disable VCS-based implicit rules.
% : s.%

.SUFFIXES: .hpux_make_needs_suffix_list

# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

#Suppress display of executed commands.
$(VERBOSE).SILENT:

# A target that is always out of date.
cmake_force:
.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /usr/bin/cmake

# The command to remove a file.
RM = /usr/bin/cmake -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = "/run/media/jmjahle/MicroSD Samsung/Bachelor Data Science/INFT-2503 C++/Assignment_3_INFT2503"

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = "/run/media/jmjahle/MicroSD Samsung/Bachelor Data Science/INFT-2503 C++/Assignment_3_INFT2503/build"

# Include any dependencies generated for this target.
include CMakeFiles/Assignment_3_INFT2503.dir/depend.make
# Include any dependencies generated by the compiler for this target.
include CMakeFiles/Assignment_3_INFT2503.dir/compiler_depend.make

# Include the progress variables for this target.
include CMakeFiles/Assignment_3_INFT2503.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/Assignment_3_INFT2503.dir/flags.make

CMakeFiles/Assignment_3_INFT2503.dir/main.cpp.o: CMakeFiles/Assignment_3_INFT2503.dir/flags.make
CMakeFiles/Assignment_3_INFT2503.dir/main.cpp.o: /run/media/jmjahle/MicroSD\ Samsung/Bachelor\ Data\ Science/INFT-2503\ C++/Assignment_3_INFT2503/main.cpp
CMakeFiles/Assignment_3_INFT2503.dir/main.cpp.o: CMakeFiles/Assignment_3_INFT2503.dir/compiler_depend.ts
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green --progress-dir="/run/media/jmjahle/MicroSD Samsung/Bachelor Data Science/INFT-2503 C++/Assignment_3_INFT2503/build/CMakeFiles" --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/Assignment_3_INFT2503.dir/main.cpp.o"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -MD -MT CMakeFiles/Assignment_3_INFT2503.dir/main.cpp.o -MF CMakeFiles/Assignment_3_INFT2503.dir/main.cpp.o.d -o CMakeFiles/Assignment_3_INFT2503.dir/main.cpp.o -c "/run/media/jmjahle/MicroSD Samsung/Bachelor Data Science/INFT-2503 C++/Assignment_3_INFT2503/main.cpp"

CMakeFiles/Assignment_3_INFT2503.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green "Preprocessing CXX source to CMakeFiles/Assignment_3_INFT2503.dir/main.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E "/run/media/jmjahle/MicroSD Samsung/Bachelor Data Science/INFT-2503 C++/Assignment_3_INFT2503/main.cpp" > CMakeFiles/Assignment_3_INFT2503.dir/main.cpp.i

CMakeFiles/Assignment_3_INFT2503.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green "Compiling CXX source to assembly CMakeFiles/Assignment_3_INFT2503.dir/main.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S "/run/media/jmjahle/MicroSD Samsung/Bachelor Data Science/INFT-2503 C++/Assignment_3_INFT2503/main.cpp" -o CMakeFiles/Assignment_3_INFT2503.dir/main.cpp.s

# Object files for target Assignment_3_INFT2503
Assignment_3_INFT2503_OBJECTS = \
"CMakeFiles/Assignment_3_INFT2503.dir/main.cpp.o"

# External object files for target Assignment_3_INFT2503
Assignment_3_INFT2503_EXTERNAL_OBJECTS =

Assignment_3_INFT2503: CMakeFiles/Assignment_3_INFT2503.dir/main.cpp.o
Assignment_3_INFT2503: CMakeFiles/Assignment_3_INFT2503.dir/build.make
Assignment_3_INFT2503: CMakeFiles/Assignment_3_INFT2503.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green --bold --progress-dir="/run/media/jmjahle/MicroSD Samsung/Bachelor Data Science/INFT-2503 C++/Assignment_3_INFT2503/build/CMakeFiles" --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable Assignment_3_INFT2503"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/Assignment_3_INFT2503.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/Assignment_3_INFT2503.dir/build: Assignment_3_INFT2503
.PHONY : CMakeFiles/Assignment_3_INFT2503.dir/build

CMakeFiles/Assignment_3_INFT2503.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/Assignment_3_INFT2503.dir/cmake_clean.cmake
.PHONY : CMakeFiles/Assignment_3_INFT2503.dir/clean

CMakeFiles/Assignment_3_INFT2503.dir/depend:
	cd "/run/media/jmjahle/MicroSD Samsung/Bachelor Data Science/INFT-2503 C++/Assignment_3_INFT2503/build" && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" "/run/media/jmjahle/MicroSD Samsung/Bachelor Data Science/INFT-2503 C++/Assignment_3_INFT2503" "/run/media/jmjahle/MicroSD Samsung/Bachelor Data Science/INFT-2503 C++/Assignment_3_INFT2503" "/run/media/jmjahle/MicroSD Samsung/Bachelor Data Science/INFT-2503 C++/Assignment_3_INFT2503/build" "/run/media/jmjahle/MicroSD Samsung/Bachelor Data Science/INFT-2503 C++/Assignment_3_INFT2503/build" "/run/media/jmjahle/MicroSD Samsung/Bachelor Data Science/INFT-2503 C++/Assignment_3_INFT2503/build/CMakeFiles/Assignment_3_INFT2503.dir/DependInfo.cmake" "--color=$(COLOR)"
.PHONY : CMakeFiles/Assignment_3_INFT2503.dir/depend

