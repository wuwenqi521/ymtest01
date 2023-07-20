from conan.tools.microsoft import is_msvc, msvc_runtime_flag
from conan.tools.build import can_run
from conan.tools.scm import Version
from conan.tools import files
from conan import ConanFile
from conans import CMake, tools
from conan.errors import ConanInvalidConfiguration
import functools
import os

class FollyConan(ConanFile):
    name = "folly"
    description = "An open-source C++ components library developed and used at Facebook"
    topics = ("facebook", "components", "core", "efficiency")
    url = "https://github.com/conan-io/conan-center-index"
    homepage = "https://github.com/facebook/folly"
    license = "Apache-2.0"
    settings = "os", "arch", "compiler", "build_type"
    build_requires = (
        "meson/[>=0.62.0]",
    )

    def requirements(self):
        self.requires("libunwind/1.5.0")
        if not is_msvc(self):
            self.requires("libdwarf/20191104")
        self.requires("libsodium/1.0.18")
        if self.settings.os == "Linux":
            self.requires("libiberty/9.1.0")

    def build_requirements(self):
        if self.options.enable_testing:
            self.test_requires("cpputest/4.0")
