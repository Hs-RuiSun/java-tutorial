package com.ruby.sun.unitest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandlerFactory;

import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import com.ruby.sun.unittest.HttpUrlStreamHandler;
import com.ruby.sun.unittest.URLRead;

public class URLReadTest {
    private static HttpUrlStreamHandler httpUrlStreamHandler;

    @BeforeClass
    public static void setupURLStreamHandlerFactory() {
        URLStreamHandlerFactory urlStreamHandlerFactory = Mockito.mock(URLStreamHandlerFactory.class);
        URL.setURLStreamHandlerFactory(urlStreamHandlerFactory);

        httpUrlStreamHandler = new HttpUrlStreamHandler();
        Mockito.when(urlStreamHandlerFactory.createURLStreamHandler("http")).thenReturn(httpUrlStreamHandler);
    }

    @Before
    public void reset() {
        httpUrlStreamHandler.resetConnections();
    }

    @Test
    public void shouldReadImage() throws Exception {
        // Given
        URLRead imageLoader = new URLRead();

        String href = "http://some.host.com/image.gif";

        URLConnection urlConnection = Mockito.mock(URLConnection.class);
        httpUrlStreamHandler.addConnection(new URL(href), urlConnection);

        byte[] expectedImageBytes = toBytes(
                0x47, 0x49, 0x46, 0x38, 0x39, 0x61, 0x0A, 0x00, 0x0A, 0x00, 0x91, 0x00, 0x00, 0xFF, 0xFF, 0xFF,
                0xFF, 0x00, 0x00, 0x00, 0x00, 0xFF, 0x00, 0x00, 0x00, 0x21, 0xF9, 0x04, 0x00, 0x00, 0x00, 0x00,
                0x00, 0x2C, 0x00, 0x00, 0x00, 0x00, 0x0A, 0x00, 0x0A, 0x00, 0x00, 0x02, 0x16, 0x8C, 0x2D, 0x99,
                0x87, 0x2A, 0x1C, 0xDC, 0x33, 0xA0, 0x02, 0x75, 0xEC, 0x95, 0xFA, 0xA8, 0xDE, 0x60, 0x8C, 0x04,
                0x91, 0x4C, 0x01, 0x00, 0x3B);
        InputStream imageInputStream = new ByteArrayInputStream(expectedImageBytes);
        Mockito.when(urlConnection.getInputStream()).thenReturn(imageInputStream);

        byte[] imageBytes = imageLoader.readImage(href);

        assertArrayEquals(imageBytes, expectedImageBytes);
    }

    @Test(expected = FileNotFoundException.class)
    @Ignore
    public void shouldFailToReadImageGivenInvalidHref() throws Exception {
        // Given
        URLRead imageLoader = new URLRead();

        String href = "http://some.host.com/bad-image-reference.gif";

        URLConnection urlConnection = Mockito.mock(URLConnection.class);
        httpUrlStreamHandler.addConnection(new URL(href), urlConnection);

        IOException fileNotFoundException = new FileNotFoundException(href);
        Mockito.when(urlConnection.getInputStream()).thenThrow(fileNotFoundException);

        //expected throw fileNotFoundException
        try {
            byte[] imageBytes = imageLoader.readImage(href);
            fail("Was expecting a RuntimeException with FileNotFoundException");
        } catch (RuntimeException e) {
            //assertEquals(e.getCause(), FileNotFoundException.class);
        }
    }

    private static byte[] toBytes(int... ints) {
        byte[] result = new byte[ints.length];
        for (int i = 0; i < ints.length; i++) {
            result[i] = (byte) ints[i];
        }
        return result;
    }
}
