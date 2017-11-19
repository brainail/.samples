package org.brainail.Everboxing.sample.NetworkPaging.model;

/**
 * This file is part of Everboxing modules. <br/><br/>
 * <p>
 * The MIT License (MIT) <br/><br/>
 * <p>
 * Copyright (c) 2017 Malyshev Yegor aka brainail at org.brainail.everboxing@gmail.com <br/><br/>
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy <br/>
 * of this software and associated documentation files (the "Software"), to deal <br/>
 * in the Software without restriction, including without limitation the rights <br/>
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell <br/>
 * copies of the Software, and to permit persons to whom the Software is <br/>
 * furnished to do so, subject to the following conditions: <br/><br/>
 * <p>
 * The above copyright notice and this permission notice shall be included in <br/>
 * all copies or substantial portions of the Software. <br/><br/>
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR <br/>
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, <br/>
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE <br/>
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER <br/>
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, <br/>
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN <br/>
 * THE SOFTWARE.
 */
public class KitsuItemAttributes {
    public String synopsis;
    public String subtype;
    public KitsuItemAttributesTitles titles;
    public KitsuItemAttributesImage posterImage;
    
    public KitsuItemAttributes(
            final String synopsis,
            final String subtype,
            final KitsuItemAttributesTitles titles,
            final KitsuItemAttributesImage posterImage) {
        
        this.synopsis = synopsis;
        this.subtype = subtype;
        this.titles = titles;
        this.posterImage = posterImage;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        final KitsuItemAttributes that = (KitsuItemAttributes) o;
        
        if (synopsis != null ? !synopsis.equals(that.synopsis) : that.synopsis != null) return false;
        if (subtype != null ? !subtype.equals(that.subtype) : that.subtype != null) return false;
        if (titles != null ? !titles.equals(that.titles) : that.titles != null) return false;
        return posterImage != null ? posterImage.equals(that.posterImage) : that.posterImage == null;
    }
    
    @Override
    public int hashCode() {
        int result = synopsis != null ? synopsis.hashCode() : 0;
        result = 31 * result + (subtype != null ? subtype.hashCode() : 0);
        result = 31 * result + (titles != null ? titles.hashCode() : 0);
        result = 31 * result + (posterImage != null ? posterImage.hashCode() : 0);
        return result;
    }
    
    @Override
    public String toString() {
        return "KitsuItemAttributes{" +
                "synopsis='" + synopsis + '\'' +
                ", subtype='" + subtype + '\'' +
                ", titles=" + titles +
                ", posterImage=" + posterImage +
                '}';
    }
}
