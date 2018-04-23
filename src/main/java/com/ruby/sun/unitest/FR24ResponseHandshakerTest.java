package com.ruby.sun.unitest;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;

public class FR24ResponseHandshakerTest {
	@Mock
	InputStream in;
	@Mock
	DataInputStream din;
	@Mock
	OutputStream out;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void handshakeTest() {
		try {
			when(in.read()).thenReturn(1);
			PowerMockito.whenNew(DataInputStream.class).withArguments(in).thenReturn(din);
			PowerMockito.when(in.read(any(byte[].class))).thenReturn(16);
			PowerMockito.when(din.readLine()).thenReturn("why");
			//PowerMockito.when(din.read(any(byte[].class))).thenReturn(16);
			/*PowerMockito.doAnswer(new Answer<Integer>() {
				@Override
				public Integer answer(InvocationOnMock arg0) throws Throwable {
					byte[] challenge = new byte[16];
					return challenge.length;
				}
			}).when(din).readFully(any(byte[].class));*/
			/*doAnswer(new Answer<Integer>() {
				@Override
				public Integer answer(InvocationOnMock arg0) throws Throwable {
					byte[] challenge = new byte[16];
					return challenge.length;
				}
			}).when(din).readFully(any(byte[].class));*/
			
			//fr24ResponseHandshaker.handshake(transportation);
			
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Exception in challengeResponseTest");
		}
	}
}
