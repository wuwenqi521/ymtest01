#!/usr/bin/env python
import codecs
import os
import sys

from setuptools import find_packages, setup

required = [
    "jsonnet>=0.10.0"
]
extras = {
    "tests": ["pytest>=5.0"]
}


setup(
    name="pipenv",
    version=about["__version__"],
    description="Python Development Workflow for Humans.",
    long_description=long_description,
    long_description_content_type="text/markdown",
    author="Pipenv maintainer team",
    author_email="distutils-sig@python.org",
    url="https://github.com/pypa/pipenv",
    packages=find_packages(exclude=["tests", "tests.*", "tasks", "tasks.*"]),
    python_requires=">=3.7",
    setup_requires=[],
    install_requires=required,
    extras_require=extras,
)
