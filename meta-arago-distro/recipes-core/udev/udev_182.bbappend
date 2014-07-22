
do_install_append () {
	ln -s ${D}/usr/lib/libudev.so  ${D}/usr/lib/libudev.so.0
}
FILES_${PN} += "${libdir}/libudev.so.0"
