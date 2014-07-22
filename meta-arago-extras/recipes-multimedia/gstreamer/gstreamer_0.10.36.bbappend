SRC_URI = "git://git.ti.com/glsdk/gstreamer0-10.git;protocol=git"
SRCREV = "e505f4a2ceee3b0328eb2efddb9ec1281d3fd60a"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=55ca817ccb7d5b5b66355690e9abc605"

COMPATIBLE_MACHINE = "omap-a15"

PR = "r0"

S = "${WORKDIR}/git"

do_configure_prepend() {
	git submodule init && git submodule update
	autopoint -f
}
