BRANCH = "glsdk_6.10"
SRCREV = "31dddd08058ff35ca44467bc9eb86930aa245b15"

SRC_URI = "git://git.ti.com/glsdk/ltp-ddt.git;protocol=git;branch=${BRANCH}"

PR = "r3"

FILESEXTRAPATHS_prepend := "${THISDIR}:"
