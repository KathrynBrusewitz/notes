import React, { PropTypes } from "react";
import ClockDisplay from "./ClockDisplay";
import TopOverlay from "./TopOverlay";
import SlideToUnlock from "./SlideToUnlock";

export default class LockScreen extends React.Component {
  // wallpaperPath is expected to be a string, and is optional
  // userInfoMessage is expected to be a string, and is optional
  // onUnlocked is expected to be a function, and is optional
  static propTypes = {
    wallpaperPath: PropTypes.string,
    userInfoMessage: PropTypes.string,
    onUnlocked: PropTypes.func,
  };
  // Don’t test prop types because it is already covered by library code

  render() {
    const {
      wallpaperPath,
      userInfoMessage,
      onUnlocked,
    } = this.props;

    return (
      // A div is always rendered and has a particular set of inline styles
      <div
        style={{
          height: "100%",
          display: "flex",
          justifyContent: "space-between",
          flexDirection: "column",
          // If a wallpaperPath prop was passed, then this div's CSS background-image
          // should be a url to that wallpaperPath. Otherwise, it should be an empty
          // string (which means the style should not be set).
          backgroundImage: wallpaperPath ? `url(${wallpaperPath})` : "",
          backgroundColor: "black",
          backgroundPosition: "center",
          backgroundSize: "cover",
        }}
      >
        {/* A ClockDisplay is always rendered and does not receive any props */}
        <ClockDisplay />
        {/*
          If a userInfoMessage prop was passed, render that userInfoMessage within
          a TopOverlay. Otherwise, don't render anything here (null).
        */}
        {userInfoMessage ? (
          <TopOverlay
            style={{
              padding: "2em",
              marginBottom: "auto",
            }}
          >
            {userInfoMessage}
          </TopOverlay>
        ) : null}
        {/*
          A SlideToUnlock is always rendered and receives the value of the passed
          onUnlocked prop as its onSlide prop, regardless of it is was defined
          or not.
        */}
        <SlideToUnlock onSlide={onUnlocked} />
      </div>
    );
  }
}