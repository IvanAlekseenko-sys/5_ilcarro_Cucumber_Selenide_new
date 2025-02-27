package ilcarro.stepDefinitions;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.selenide.videorecorder.core.VideoRecorder;

public class Hooks {
    private final VideoRecorder videoRecorder = new VideoRecorder();

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("🎬 Запускаем тест: " + scenario.getName());
        videoRecorder.start();
    }

    @After
    public void afterScenario(Scenario scenario) {
        String videoPath = String.valueOf(videoRecorder.videoUrl().orElse(null));
        videoRecorder.finish();

        if (scenario.isFailed()) {
            System.out.println("❌ Тест упал: " + scenario.getName());
            Selenide.screenshot("failed_test");
            System.out.println("📸 Скриншот сохранён в reports/.");
        } else {
            System.out.println("✅ Тест пройден успешно: " + scenario.getName());
        }

        System.out.println("🎥 Видео теста: " + videoPath);
    }
}
