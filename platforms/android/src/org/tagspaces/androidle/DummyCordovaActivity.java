package org.tagspaces.androidle;

import org.apache.cordova.CordovaActivity;

/**
 * This class is simply here to make sure Cordova will build. Without it, even
 * though it's not used or otherwise referenced, you will get a build error that
 * looks like "Error: No Java files found which extend CordovaActivity".
 * http://stackoverflow.com/questions/20354846/upgrading-from-cordova-2-5-to-cordova-3-0-facing-issue-while-using-cordovainte
 */
public class DummyCordovaActivity extends CordovaActivity {

}