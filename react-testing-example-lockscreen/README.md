# React Component Testing

This project demonstrates a Lock Screen implemented in React and some tests around it.

![Animated GIF showing Lock Screen](/example.gif?raw=true)

Follow the tutorial: [The Right Way to Test React Components](https://medium.freecodecamp.com/the-right-way-to-test-react-components-548a4736ab22)

---

## Contract

> A contract defines the expected behavior of your component and what assumptions are reasonable to have about its usage.

1. To find constraints in its contract, comment where behavior can differ. Look for ternaries, if statements, and switch statements.

2. Some of these constraints are worth testing and others are not. Some rules to determine that something is not worth testing:

  > 1. Will the test have to duplicate exactly the application code? This will make it brittle.

  > 2. Will making assertions in the test duplicate any behavior that is already covered by (and the responsibility of) library code?

  > 3. From an outsider’s perspective, is this detail important, or is it only an internal concern? Can the effect of this internal detail be described using only the component’s public API?

3. Don't test propTypes (breaks rule 2), don't test don’t test inline styles, unless they can change at runtime (breaks rule 1).

4. Do test when constraints fall under a category like: "Some composite component is rendered" and "the rendered component receives these props". Always test your public interface, e.g. when the background-image depends on a prop, you should test the effect of that prop.

## Test Boilerplate

```js
import React from "react";
import { mount } from "enzyme";
import LockScreen from "./LockScreen";

describe("LockScreen", () => {
  let props;
  let mountedLockScreen;
  const lockScreen = () => {
    if (!mountedLockScreen) {
      mountedLockScreen = mount(
        <LockScreen {...props} />
      );
    }
    return mountedLockScreen;
  }

  beforeEach(() => {
    props = {
      wallpaperPath: undefined,
      userInfoMessage: undefined,
      onUnlocked: undefined,
    };
    mountedLockScreen = undefined;
  });

  // All tests will go here
});
```

`lockScreen` function is returned an enzyme [`ReactWrapper`](http://airbnb.io/enzyme/docs/api/mount.html). This is used in every test.

`beforeEach` resets the `props` and `mountedLockScreen` variables before every test. By setting `mountedLockScreen` to `undefined`, when the next test runs, if it calls `lockScreen`, a new `LockScreen` will be mounted with the current `props`.

## Writing Tests

### Constraints that are always true

A `div` is always rendered.

```js
it("always renders a div", () => {
  const divs = lockScreen().find("div");
  expect(divs.length).toBeGreaterThan(0);
});
```

The rendered `div` contains everything else that gets rendered.

```js
describe("the rendered div", () => {
  it("contains everything else that gets rendered", () => {
    const divs = lockScreen().find("div");
    // When using .find, enzyme arranges the nodes in order such
    // that the outermost node is first in the list. So we can
    // use .first() to get the outermost div.
    const wrappingDiv = divs.first();

    // Enzyme omits the outermost node when using the .children()
    // method on lockScreen(). This is annoying, but we can use it
    // to verify that wrappingDiv contains everything else this
    // component renders.
    expect(wrappingDiv.children()).toEqual(lockScreen().children());
  });
});
```

A `ClockDisplay` is always rendered.

```js
it("always renders a `ClockDisplay`", () => {
  expect(lockScreen().find(ClockDisplay).length).toBe(1);
});
```

The rendered `ClockDisplay` does not receive any props.

```js
describe("rendered `ClockDisplay`", () => {
  it("does not receive any props", () => {
    const clockDisplay = lockScreen().find(ClockDisplay);
    expect(Object.keys(clockDisplay.props()).length).toBe(0);
  });
});
```

A `SlideToUnlock` is always rendered.

```js
it("always renders a `SlideToUnlock`", () => {
  expect(lockScreen().find(SlideToUnlock).length).toBe(1);
});
```

### Constraints that are conditionally true

When the passed `onUnlocked` prop is defined, the rendered SlideToUnlock receives that prop’s value as its onSlide prop.

```js
describe("when `onUnlocked` is defined", () => {
  beforeEach(() => {
    props.onUnlocked = jest.fn();
  });

  it("sets the rendered `SlideToUnlock`'s `onSlide` prop to the same value as `onUnlocked`'", () => {
    const slideToUnlock = lockScreen().find(SlideToUnlock);
    expect(slideToUnlock.props().onSlide).toBe(props.onUnlocked);
  });
});
```

When the passed `onUnlocked` prop is `undefined`, the rendered `SlideToUnlock`'s `onSlide` prop should also be set to `undefined`.

```js
describe("when `onUnlocked` is undefined", () => {
  beforeEach(() => {
    props.onUnlocked = undefined;
  });

  it("sets the rendered `SlideToUnlock`'s `onSlide` prop to undefined'", () => {
    const slideToUnlock = lockScreen().find(SlideToUnlock);
    expect(slideToUnlock.props().onSlide).not.toBeDefined();
  });
});
```











