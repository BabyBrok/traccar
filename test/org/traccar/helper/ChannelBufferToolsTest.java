package org.traccar.helper;

import org.jboss.netty.buffer.ChannelBuffers;
import org.junit.Assert;
import org.junit.Test;

public class ChannelBufferToolsTest {
    
    @Test
    public void testReadHexInteger() {
        byte[] buf = {0x01, (byte) 0x90, 0x34};
        int result = ChannelBufferTools.readHexInteger(
                ChannelBuffers.wrappedBuffer(buf), 5);
        Assert.assertEquals(1903, result);
    }

    @Test
    public void testReadCoordinate() {
        byte[] buf = {0x03, (byte) 0x85, 0x22, 0x59, 0x34};
        double result = ChannelBufferTools.readCoordinate(
                ChannelBuffers.wrappedBuffer(buf));
        Assert.assertEquals(38.870989, result, 0.00001);
    }

}
