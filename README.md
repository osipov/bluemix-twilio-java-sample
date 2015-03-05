# Twilio

##Twilio Telephony as a Service

Twilio enables phones, VoIP, and messaging to be embedded into web, desktop, and mobile software. To try Twilio on Bluemix, you will first need to register for a Twilio account (unless you already have one) using the following link https://www.twilio.com/try-twilio?promo=bluemix

You will also need a number that can receive text messages. This number must be verified with Twilio using the following link http://twilio.com/user/account/phone-numbers/verified

**If you are going to use Java**

Once you are registered with Twilio and ready to try the sample Twilio application, change directory to ```bluemix-twilio-java-sample```  and execute the following commands from your console.

```
cf login https://api.ng.bluemix.net
cf push
```

After the command completes successfully, look for the console output specifying the application URL. It should look something like 

```
usage: 128M x 1 instances
urls: fiu-hackathon-2015-random-word.mybluemix.net
```

Take note of the URL ending with mybluemix.net (such as fiu-hackathon-2015-random-word.mybluemix.net in the example above) from the console output. You will need it later to access the application.

Twilio service must be bound to your application using the Bluemix UI. Login to Bluemix and using the Dashboard menu item, navigate to your application. Click on your application, click Add a service and choose Twilio from the catalog. On the right side bar, specify ```Twilio``` as the service name and enter the Twilio SID and token values as available from your Twilio dashboard.

A more detailed example of binding Twilio service to your application is available from https://twilio.com/blog/2014/02/twilio-and-ibm-codename-bluemix-nt.html

Next execute the following commands from your console, using your Twilio assigned phone number instead of the  ```<TWILIO_NUMBER>``` string and using the application SID instead of ```<APP_SID>```.

```
cf set-env fiu-hackathon-2015 MY_TWILIO_NUMBER <TWILIO_NUMBER>
cf set-env fiu-hackathon-2015 APP_SID <APP_SID>
cf restage fiu-hackathon-2015
```

To test the application, open your favorite browser using the application URL you noted earlier, i.e the one ending with mybluemix.net.

##Files

The application contains the following contents:

*   webstarterapp.war

    This WAR file is actually the application itself. It is the only file that'll be pushed to and run on the Bluemix cloud. Every time your application code is updated, you'll need to regenerate this WAR file and push to Bluemix again. See the next section on detailed steps.
    
*   WebContent/

    This directory contains the client side code (HTML/CSS/JavaScript) of your application as well as compiled server side java classes and necessary JAR libraries.
    
*   src/

    This directory contains the server side code (JAVA) of your application.
    
*   build.xml

    This file allows you to easily build your application using Ant.