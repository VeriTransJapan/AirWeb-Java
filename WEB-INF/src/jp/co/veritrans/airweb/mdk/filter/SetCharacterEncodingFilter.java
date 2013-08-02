/*
* Copyright 2004 The Apache Software Foundation
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package jp.co.veritrans.airweb.mdk.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

/**
 * <p>
 * Example filter that sets the character encoding to be
 * used in parsing the incoming request, either
 * unconditionally or only if the client did not specify a
 * character encoding. Configuration of this filter is based
 * on the following initialization parameters:
 * </p>
 * <ul>
 * <li><strong>encoding</strong> - The character encoding to
 * be configured for this request, either conditionally or
 * unconditionally based on the <code>ignore</code>
 * initialization parameter. This parameter is required, so
 * there is no default.</li>
 * <li><strong>ignore</strong> - If set to "true", any
 * character encoding specified by the client is ignored,
 * and the value returned by the
 * <code>selectEncoding()</code> method is set. If set to
 * "false, <code>selectEncoding()</code> is called
 * <strong>only</strong> if the client has not already
 * specified an encoding. By default, this parameter is set
 * to "true".</li>
 * </ul>
 * 
 * <p>
 * Although this filter can be used unchanged, it is also
 * easy to subclass it and make the
 * <code>selectEncoding()</code> method more intelligent
 * about what encoding to choose, based on characteristics
 * of the incoming request (such as the values of the
 * <code>Accept-Language</code> and <code>User-Agent</code>
 * headers, or a value stashed in the current user's
 * session.
 * </p>
 * 
 * @author Craig McClanahan
 * @version $Revision: 1.2 $ $Date: 2006/12/05 04:57:20 $
 */

public class SetCharacterEncodingFilter implements Filter {

    /**
     * ログ
     */
    private static Logger log = Logger.getLogger(SetCharacterEncodingFilter.class);
    // ----------------------------------------------------- Instance Variables

    /**
     * The default character encoding to set for requests
     * that pass through
     * this filter.
     */
    private String encoding = null;

    /**
     * Should a character encoding specified by the client
     * be ignored?
     */
    private boolean ignore = true;

    // --------------------------------------------------------- Public Methods

    /**
     * Take this filter out of service.
     */
    @Override
    public void destroy() {

        this.encoding = null;

    }

    /**
     * Select and set (if specified) the character encoding
     * to be used to
     * interpret request parameters for this request.
     * 
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     * 
     * @exception IOException if an input/output error
     *                occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
            throws IOException, ServletException {

        // Conditionally select and set the character encoding to be used
        if (this.ignore || request.getCharacterEncoding() == null) {
            String encod = selectEncoding();
            if (encod != null) {
                request.setCharacterEncoding(encod);
            }
        }
        if (log.isDebugEnabled()) {
            log.debug("CONTENT-TYPE(request):" + request.getContentType()); //$NON-NLS-1$
            log.debug("CONTENT-TYPE(response):" + response.getContentType()); //$NON-NLS-1$
            log.debug("CharacterEncoding:" + request.getCharacterEncoding()); //$NON-NLS-1$
            log.debug("headers"); //$NON-NLS-1$
            Enumeration enumeration1 = ((HttpServletRequest)request).getHeaderNames();
            while (enumeration1.hasMoreElements()) {
                String key = (String)enumeration1.nextElement();
                log.debug(key + "=" + ((HttpServletRequest)request).getHeader(key)); //$NON-NLS-1$
            }
            log.debug("atributes"); //$NON-NLS-1$
            Enumeration enumeration = request.getAttributeNames();
            while (enumeration.hasMoreElements()) {
                String key = (String)enumeration.nextElement();
                log.debug(key + "=" + request.getAttribute(key)); //$NON-NLS-1$
            }

            log.debug("parameters"); //$NON-NLS-1$
            Iterator it = request.getParameterMap().entrySet().iterator();
            while (it.hasNext()) {
                log.debug(it.next());
            }
        }
        // Pass control on to the next filter
        chain.doFilter(request, response);

    }

    /**
     * Place this filter into service.
     * 
     * @param filter The filter configuration object
     */
    @Override
    public void init(final FilterConfig filter) {

        this.encoding = filter.getInitParameter("encoding"); //$NON-NLS-1$
        log.debug("SetCharacterEncoding CharacterSet = " + this.encoding); //$NON-NLS-1$
        String value = filter.getInitParameter("ignore"); //$NON-NLS-1$
        log.debug("SetCharacterEncoding CharacterSet is ignore = " + value); //$NON-NLS-1$
        if (value == null) {
            this.ignore = true;
        } else if (value.equalsIgnoreCase("true")) { //$NON-NLS-1$
            this.ignore = true;
        } else if (value.equalsIgnoreCase("yes")) { //$NON-NLS-1$
            this.ignore = true;
        } else {
            this.ignore = false;
        }
    }

    // ------------------------------------------------------ Protected Methods

    /**
     * Select an appropriate character encoding to be used,
     * based on the
     * characteristics of the current request and/or filter
     * initialization
     * parameters. If no character encoding should be set,
     * return <code>null</code>.
     * <p>
     * The default implementation unconditionally returns
     * the value configured by the <strong>encoding</strong>
     * initialization parameter for this filter.
     * 
     * @return エンコーディング
     */
    protected String selectEncoding() {

        return this.encoding;

    }

}
