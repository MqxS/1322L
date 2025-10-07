package assignment4;

public class Music extends Media implements IAudioStandard {
    final String audioCodec;

    public Music(final String fileName, final String audioCodec) {
        super(fileName);
        this.audioCodec = audioCodec;
    }

    @Override
    public String getAudioCodec() {
        return String.format("Audio codec: %s", audioCodec);
    }

    @Override
    public String getMediaInfo() {
        return String.format(
                "Music ID: %s%n" +
                "Music name: %s%n" +
                "Audio codec: %s",
                getId(), getFileName(), audioCodec
        );
    }
}
