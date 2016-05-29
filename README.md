# Grid-MavenWebDriverGoogleSearch

java -jar selenium-server-standalone-2.53.0.jar -role hub

java -jar selenium-server-standalone-2.47.1.jar –role webdriver –hub http://<hostname/ip of hub>:4444/grid/register –port 5556

java -jar selenium-server-standalone-2.53.0.jar –role webdriver –hub http://192.168.1.12:4444/grid/register –port 5556

Command to launch node for running Chrome Driver:
java -jar selenium-server-standalone-2.53.0.jar –role webdriver –hub http://192.168.1.12:4444/grid/register –port 5555 -DWebDriver.chrome.driver=C:\Users\kusha_000\Downloads\

java -jar selenium-server-standalone-2.53.0.jar –role webdriver –hub http://192.168.1.12:4444/grid/register –port 5556 -DWebDriver.chrome.driver=C:\Users\kusha_000\Downloads\


java -jar selenium-server-standalone-2.53.0.jar -role node –hub http://192.168.1.12:4444/grid/register -DWebDriver.chrome.driver=C:\Users\kusha_000\Downloads\ -browser "browserName=Chrome,version=50.0.2661.102 m, platform=WIN10" –port 5555


java -jar selenium-server-standalone-2.53.0.jar –role webdriver –hub http://192.168.1.12:4444/grid/register -browser "browserName=firefox,version=38.0, platform=WIN10" –port 5556


java -jar selenium-server-standalone-2.53.0.jar –role webdriver –hub http://192.168.1.12:4444/grid/register -browser "browserName=firefox,version=38.0, platform=WIN10" –port 5557
