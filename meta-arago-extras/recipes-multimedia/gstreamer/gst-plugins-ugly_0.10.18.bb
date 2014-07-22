require recipes-multimedia/gstreamer/gst-plugins.inc

LICENSE = "GPLv2+ & LGPLv2.1+ & LGPLv2+"
LICENSE_FLAGS = "commercial"
LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343"

SRC_URI = "git://git.ti.com/glsdk/gst-plugins-ugly0-10.git;protocol=git"
SRCREV = "863d08791774bdfb96ba4c0e46d0098f6a329c03"

DEPENDS += "gst-plugins-base libid3tag libmad mpeg2dec liba52 lame"
PR = "r0"

S = "${WORKDIR}/git"

inherit gettext

do_configure() {
     ./autogen.sh --host=arm-linux --disable-gtk-doc --with-libtool-sysroot=${STAGING_DIR_TARGET} --prefix=/usr 
}

FILES_${PN} += "\
                ${libdir}/*.so \
                ${libdir}/gstreamer-0.10/*"
