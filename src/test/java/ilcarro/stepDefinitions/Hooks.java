package ilcarro.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.selenide.videorecorder.core.VideoRecorder;

public class Hooks {
    private final VideoRecorder videoRecorder = new VideoRecorder();

    @Before
    public void beforeScenario(Scenario scenario) {
        scenario.log("🎥 Начинаем запись видео: " + scenario.getName());
        videoRecorder.start();
    }

    @After
    public void afterScenario(Scenario scenario) {
        String videoPath = String.valueOf(videoRecorder.videoUrl());
        videoRecorder.finish();
        scenario.log("🎥 Видео теста: " + videoPath);
    }
}
