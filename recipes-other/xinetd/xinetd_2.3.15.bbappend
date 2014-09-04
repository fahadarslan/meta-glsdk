
SRC_URI = "http://pkgs.fedoraproject.org/repo/pkgs/xinetd/xinetd-2.3.15.tar.gz/77358478fd58efa6366accae99b8b04c/xinetd-${PV}.tar.gz \
      file://xinetd.init \
      file://xinetd.conf \
      file://xinetd.default \
      file://Various-fixes-from-the-previous-maintainer.patch \
      file://Disable-services-from-inetd.conf-if-a-service-with-t.patch \
      file://xinetd-should-be-able-to-listen-on-IPv6-even-in-ine.patch \
      file://xinetd-CVE-2013-4342.patch \
      "

