cmake_minimum_required(VERSION 3.5)

project(Assignment_4_INFT2503)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++1y -Wall -Wextra -Wno-unused-parameter")

INCLUDE(FindPkgConfig)

if(APPLE)
  set(ENV{PKG_CONFIG_PATH} "$ENV{PKG_CONFIG_PATH}:/usr/local/lib/pkgconfig:/opt/X11/lib/pkgconfig:/usr/local/Cellar/libffi/3.2.1/lib/pkgconfig:/usr/local/Cellar/libsigc++@2/2.10.2/lib/pkgconfig")
endif()

pkg_check_modules(GTKMM gtkmm-3.0 REQUIRED)
include_directories(${GTKMM_INCLUDE_DIRS})
link_directories(${GTKMM_LIBRARY_DIRS})

add_executable(Assignment_4_INFT2503
    main.cpp
    task_1.cpp
    task_1.h
    task_2.cpp
    task_2.h
)
target_link_libraries(Assignment_4_INFT2503  ${GTKMM_LIBRARIES})
