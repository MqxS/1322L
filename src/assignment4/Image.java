package assignment4;

public class Image extends Media implements IImageStandard {
    final String imageCodec;

    public Image(final String fileName, final String imageCodec) {
        super(fileName);
        this.imageCodec = imageCodec;
    }

    @Override
    public String getImageCodec() {
        return String.format("Image Codec: %s", imageCodec);
    }

    @Override
    public String getMediaInfo() {
        return String.format(
                "Image ID: %s%n" +
                "Image name: %s%n" +
                "Image codec: %s",
                getId(), getFileName(), imageCodec
        );
    }
}
