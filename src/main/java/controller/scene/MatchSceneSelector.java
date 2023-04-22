package controller.scene;

import exceptions.UnsupportedResolutionException;

/**
 * This class is responsible for selecting the appropriate FXML file for the match scene based on the screen resolution.
 * If the screen resolution is not supported, an UnsupportedResolutionException is thrown.
 * @author gerardocipriano
 */
public class MatchSceneSelector {
    /**
     * Returns the path to the FXML file for the match scene based on the screen resolution.
     * @param screenWidth The width of the screen.
     * @param screenHeight The height of the screen.
     * @return The path to the FXML file for the match scene.
     * @throws UnsupportedResolutionException If the screen resolution is not supported.
     */
    public String getMatchSceneFxmlPath(double screenWidth, double screenHeight) throws UnsupportedResolutionException {
        if (screenWidth == 1920.0 && screenHeight == 1080.0) {
            return "layouts/MatchGui1920x1080.fxml";
        } else if (screenWidth == 1366.0 && screenHeight == 768.0) {
            return "layouts/MatchGui1366x768.fxml";
        } else if (screenWidth == 1280.0 && screenHeight == 720.0) {
            return "layouts/MatchGui1280x720.fxml";
        } else {
            throw new UnsupportedResolutionException("The screen resolution is not supported. Please set one of the following resolutions: 1920x1080, 1366x768 or 1280x720.");
        }
    }
}
