package ru.otus.homework.vitalib.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.homework.vitalib.service.CliRunner;

@ShellComponent
@RequiredArgsConstructor
public class TestsRunner {
    private final CliRunner cliRunner;

    @ShellMethod(value = "Start testing", key = {"t", "test"})
    public void startTesting() {
        cliRunner.run();
    }
}
