package com.gmail.stepan1983;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class MessageProviderRenderFactory {

    private static MessageProvider provider;
    private static MessageRenderer renderer;

    static {

        Properties properties = new Properties();

        System.out.println("factory creation");

        try (InputStream is = MessageProviderRenderFactory.class
                .getClassLoader().getResourceAsStream("app.properties")) {

//            System.out.println(is.toString());

            properties.load(is);

            System.out.println(properties.getProperty("provider"));

            provider = (MessageProvider) Class.forName(properties.getProperty("provider"))
                    .newInstance();

            System.out.println(provider.getClass().toString());

            renderer = (MessageRenderer) Class.forName(properties.getProperty("renderer"))
                    .getConstructor(MessageProvider.class).newInstance(provider);

            System.out.println(renderer.getClass());

        } catch (IOException e) {
            e.getStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public static MessageProvider getProvider() {
        return provider;
    }

    public static MessageRenderer getRenderer() {
        return renderer;
    }
}
