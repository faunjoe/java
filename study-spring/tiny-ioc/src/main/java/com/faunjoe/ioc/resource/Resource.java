package com.faunjoe.ioc.resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * Resource资源接口
 * @author faunjoe
 */
public interface Resource {
	InputStream getInputStream() throws IOException;
}
