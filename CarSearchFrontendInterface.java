public interface CarSearchFrontendInterface {
    //public CarSearchFrontendInterface (Scanner userInput, CarSearchBackendInterface backend);
    public void runCommandLoop();
    public char mainMenuPrompt();
    public void loadFile();
    public String getUserInput();
    public void searchCarByPrice(String price);
    public void searchCheapest();
    public void searchPriciest();
    public void searchCheapestAbovePrice(String minPrice);
    public void printCarDetails(CarFD car);
    
}
