DEFAULT_PREFERENCE = "1"

include gstreamer1.0.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6762ed442b3822387a51c92d928ead0d \
                    file://gst/gst.h;beginline=1;endline=21;md5=e059138481205ee2c6fc1c079c016d0d"

SRC_URI = " \
	git://anongit.freedesktop.org/gstreamer/gstreamer;branch=master \
	file://0001-Fix-crash-with-gst-inspect.patch \
	file://0001-revert-use-new-gst-adapter-get-buffer.patch \
"

S = "${WORKDIR}/git"

SRCREV = "a65e18d89015b545377274b758d0f3f523952d53"

inherit gitpkgv
PV = "1.7.1+git${SRCPV}"
PKGV = "1.7.1+git${GITPKGV}"

do_configure_prepend() {
	cd ${S}
	./autogen.sh --noconfigure
	cd ${B}
}
