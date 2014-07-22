# GLSDK branding configuration

# Use the SDK supported kernel and kernel version
PREFERRED_PROVIDER_virtual/kernel = "linux-ti-glsdk"
PREFERRED_PROVIDER_virtual/bootloader = "u-boot-glsdk-staging"
PREFERRED_PROVIDER_u-boot = "u-boot-glsdk-staging"
PREFERRED_VERSION_libgbm = "9.0.0"
PREFERRED_VERSION_libdrm = "2.4.41"
PREFERRED_PROVIDER_virtual/xserver = "xorg-xserver-glsdk"
PREFERRED_PROVIDER_xf86-video-omap = "xf86-video-omap-glsdk"
PREFERRED_PROVIDER_dri2proto = "dri2proto-glsdk"

PREFERRED_VERSION_wayland = "1.3.0"
PREFERRED_VERSION_wayland-native = "1.3.0"
PREFERRED_VERSION_weston = "1.3.0"
SRCIPK_PACKAGE_ARCH_pn-linux-ti-glsdk = "${MACHINE_ARCH}"
SRCIPK_PRESERVE_GIT_pn-linux-ti-glsdk = "true"
