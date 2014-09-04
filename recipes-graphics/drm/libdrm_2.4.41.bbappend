do_install_append() {
        mkdir -p ${D}/usr/bin/
	cp ${S}/tests/modetest/.libs/modetest ${D}/usr/bin 
}

SRCREV = "3cb5405084111193cedb8796d259b56560b088f0"
