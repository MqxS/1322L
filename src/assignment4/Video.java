package assignment4;

public class Video extends Media implements IImageStandard, IAudioStandard {
    final String imageCodec;
    final String audioCodec;

    public Video(final String fileName, final String imageCodec, final String audioCodec) {
        super(fileName);
        this.imageCodec = imageCodec;
        this.audioCodec = audioCodec;
    }

    @Override
    public String getImageCodec() {
        return String.format("Image codec: %s", imageCodec);
    }

    @Override
    public String getAudioCodec() {
        return String.format("Audio codec: %s", audioCodec);
    }

    @Override
    public String getMediaInfo() {
        return String.format(
                "Video ID: %s%n" +
                "Video name: %s%n" +
                "Image codec: %s%n" +
                "Audio codec: %s",
                getId(), getFileName(), imageCodec, audioCodec
        );
    }
}
