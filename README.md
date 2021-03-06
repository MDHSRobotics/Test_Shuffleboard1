Test_Shuffleboard1

# Test_Shuffleboard1

## Summary
This program illustrates the various capabilities of the FRC Shuffleboard dashboard.  It creates some simple subsystems and commands that can be displayed (and interacted with) via the Shuffleboard UI.  Tabs are created and populated with widgets that reflect the states of the subsystems and commands as well as other information. Also, events are logged to the Shuffleboard.

## Known Problems
* The .withProperties modifier for widgets is not working.  For example, setting the min and max values for a NumberBar is ignored.
* Displaying the state of the command scheduler is not working. According to the documentation, you just have to add the Scheduler.getInstance to a widget but that is not working. Curiously, it doesn't work for the SmarDashboard either.
* The layout of the widgets and their properties are cached so it's a bit tedious having to close and re-open the Shuffleboard app whenever you make a change.  There might be a way to clear this at startup to avoid this.
