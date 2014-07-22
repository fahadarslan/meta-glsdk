require recipes-graphics/xorg-proto/xorg-proto-common.inc

SUMMARY = "DRI2: Direct Rendering Infrastructure 2 headers"

DESCRIPTION = "This package provides the wire protocol for the Direct \
Rendering Ifnrastructure 2.  DIR is required for may hardware \
accelerated OpenGL drivers."

SRCREV = "3b88264b3b78233682c35fcc9fbd3843f4c0a9f7"
PR = "r0"

SRC_URI = "git://git.ti.com/glsdk/dri2proto.git;protocol=git"

LIC_FILES_CHKSUM="file://COPYING;md5=2e396fa91834f8786032cad2da5638f3"

S = "${WORKDIR}/git"

