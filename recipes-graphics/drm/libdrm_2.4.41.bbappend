do_install_append() {
        mkdir -p ${D}/usr/bin/
	cp ${S}/tests/modetest/.libs/modetest ${D}/usr/bin 
}
