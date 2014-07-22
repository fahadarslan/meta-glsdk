DESCRIPTION =  "Kernel drivers for the PowerVR SGX chipset found in the omap5 SoCs"
HOMEPAGE = "http://git.ti.com"
LICENSE = "MIT | GPLv2"
LIC_FILES_CHKSUM = "file://eurasia_km/README;beginline=17;endline=26;md5=74506d9b8e5edbce66c2747c50fcef12"

inherit module

MACHINE_KERNEL_PR_append = "c"
PR = "${MACHINE_KERNEL_PR}"

SRC_URI = "git://git.ti.com/graphics/omap5-sgx-ddk-linux.git;protocol=git \
           "

S = "${WORKDIR}/git"

SRCREV = "eec409d9fcd363f1f8217eb7898a96ff9024a05f"

EXTRA_OEMAKE += 'KERNELDIR="${STAGING_KERNEL_DIR}"'

do_compile_prepend() {
    cd ${S}/eurasia_km/eurasiacon/build/linux2/omap5430_linux
}

do_install() {
    mkdir -p ${D}/lib/modules/${KERNEL_VERSION}/extra/
    cp ${S}/eurasia_km/eurasiacon/binary2_omap5430_linux_release/target/kbuild/omapdrm_pvr.ko \
    ${D}/lib/modules/${KERNEL_VERSION}/extra/
}
