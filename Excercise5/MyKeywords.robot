*** Settings ***
Library    AppiumLibrary
*** Variables ***
${AppiumURL}    http://127.0.0.1:4723/wd/hub
${PlatformName}    Android
${PlatformVersion}    9
${PhoneName}    emulator-5554
${AppPackage}    com.google.android.youtube
${AppActivity}    com.google.android.apps.youtube.app.WatchWhileActivity

#search
${Search}    xpath=//android.widget.ImageView[@content-desc="Search"]
${SearchBar}     id=com.google.android.youtube:id/search_edit_text
${SearchResult}     id=com.google.android.youtube:id/text
#channel
${EnterChannel}     id=com.google.android.youtube:id/channel_name
${SwipeBar}     xpath=//android.widget.Button[@content-desc="Playlists"]
${About}     xpath=//android.widget.Button[@content-desc="About"]
${JoinDate}     id=com.google.android.youtube:id/joined_date
#videos tab
${Videos}     xpath=//android.widget.Button[@content-desc="Videos"]
${Vid}     xpath=/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.support.v4.view.ViewPager/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.ImageView
${Title}    xpath=xpath	/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.TextView[1]
${play}      id=com.google.android.youtube:id/player_control_play_pause_replay_button
#comments
${Comment}     id=com.google.android.youtube:id/message_text
#videocontrols
${Minimize}      id=com.google.android.youtube:id/player_collapse_button
${Video}     xpath=/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.View
${Back}     xpath=//android.widget.ImageButton[@content-desc="Navigate up"]
${share}    xpath=/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.view.ViewGroup/android.widget.FrameLayout/android.widget.GridLayout/android.view.ViewGroup/android.view.ViewGroup[3]
${copy}     xpath=/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.ImageView
${expand}      id=com.google.android.youtube:id/expand_button
${description}      id=com.google.android.youtube:id/description

*** Keywords ***
Provided precondition
    Setup system under test

Run application
    open Application    ${AppiumURL}  newCommandTimeout=3600    logLevel=Error    platformName=${PlatformName}    platformVersion=${PlatformVersion}    deviceName=${PhoneName}    appPackage=${AppPackage}    appActivity=${AppActivity}
    sleep     2
Search
    [Arguments]     ${SearchText}
    click element    ${search}
    sleep     2
    input text    ${SearchBar}     ${SearchText}
    sleep     2
    click element    ${SearchResult}
    sleep     2
Channel
    click element    ${EnterChannel}
VideoTab
    click element    ${Videos}
    sleep     2
    swipe     500    400    500    700    1000
    sleep     2
    click element    ${Vid}
    sleep     2
Comments
#for loop to swipe screen multiple times
    FOR    ${INDEX}    IN RANGE     1   4
        swipe     500    1500    500    100    1000
        sleep     2
    END
    ${Comments}    Get Text     ${Comment}
    sleep     1
    log to console    ${Comments}
Share
    click element     ${share}
    sleep    2
    click element      ${copy}
    sleep    2
Pauseunpause
    click element     ${Video}
    sleep    1
    click element     ${play}
    sleep    3
    click element     ${play}
    sleep    2
Description
    click element      ${expand}
    sleep    1
    ${descr}    Get Text     ${description}
    sleep     1
    log to console    ${descr}
    sleep     2
    click element      ${expand}