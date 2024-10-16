cmake_minimum_required(VERSION 3.28)
project(Assignment_6_Task2_INFT2503)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++1y -pthread -Wall -Wextra")

find_package(Boost 1.83.0 COMPONENTS system REQUIRED)
include_directories(${Boost_INCLUDE_DIR})


add_executable(Assignment_6_Task2_INFT2503 main.cpp)
target_link_libraries(Assignment_6_Task2_INFT2503 ${Boost_LIBRARIES})