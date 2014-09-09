
BRANCH = "master"
SRCREV = "04da689692ec7cd3ef0f315c9c00d9051cefdd10"
SRC_URI = "git://git.ti.com/glsdk/omapdrmtest;protocol=git;branch=${BRANCH} \
	"

DEPENDS = "libav libdce libdrm libgbm omap5-sgx-ddk-um-linux"

PR = "r5"

