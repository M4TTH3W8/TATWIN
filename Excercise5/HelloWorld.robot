*** Settings ***
Resource    MyKeywords.robot
Library     BuiltIn

*** Test Cases ***
Test 1 - Opening application
    Run application
Test 2 - Searching for PK account on youtube
    Search    Politechnika Koszalinska
Test 3 - Checking account join date
    Channel
    sleep     2
    swipe    600     300     200     300      1000
    click element     ${About}
    sleep     2
    ${text}    Get Text     ${JoinDate}
    sleep     1
    log to console    ${text}
Test 4 - Going to videos tab, refreshing and selecting first video
    VideoTab
Test 5 - Copying link to clipboard
    Share
Test 6 - Printing description
    Description
Test 7 - pausing and unpausing video
    Pauseunpause
Test 8 - Checking if coments are enabled
    Comments
Test 9 - Minimize video and return to the home screen
    click element     ${Video}
    sleep     1
    click element     ${Minimize}
    sleep     1
    click element     ${Back}
    sleep     1
    click element     ${Back}
    sleep     1
Test 10 - Close minimized video
    swipe     1025     1500      400     1500     1000
    sleep     2

*** Keywords ***