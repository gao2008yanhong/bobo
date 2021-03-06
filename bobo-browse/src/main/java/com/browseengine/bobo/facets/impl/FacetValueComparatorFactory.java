/**
 * This software is licensed to you under the Apache License, Version 2.0 (the
 * "Apache License").
 *
 * LinkedIn's contributions are made under the Apache License. If you contribute
 * to the Software, the contributions will be deemed to have been made under the
 * Apache License, unless you expressly indicate otherwise. Please do not make any
 * contributions that would be inconsistent with the Apache License.
 *
 * You may obtain a copy of the Apache License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, this software
 * distributed under the Apache License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the Apache
 * License for the specific language governing permissions and limitations for the
 * software governed under the Apache License.
 *
 * © 2012 LinkedIn Corp. All Rights Reserved.  
 */

package com.browseengine.bobo.facets.impl;

import java.util.Comparator;

import com.browseengine.bobo.api.BrowseFacet;
import com.browseengine.bobo.api.ComparatorFactory;
import com.browseengine.bobo.api.FieldValueAccessor;
import com.browseengine.bobo.util.BigSegmentedArray;
import com.browseengine.bobo.util.IntBoundedPriorityQueue.IntComparator;

public class FacetValueComparatorFactory implements ComparatorFactory {

  public IntComparator newComparator(
      FieldValueAccessor fieldValueAccessor, BigSegmentedArray counts) {
    return new IntComparator(){
      public int compare(Integer o1, Integer o2) {
        return o2-o1;
      }
      
      @SuppressWarnings("unused")
      // use polymorphism to avoid auto-boxing
      public int compare(int o1, int o2) {
        return o2-o1;
      }
    };
  }

	public Comparator<BrowseFacet> newComparator() {
		return new Comparator<BrowseFacet>(){
			public int compare(BrowseFacet o1, BrowseFacet o2) {				
				return o1.getValue().compareTo(o2.getValue());
			}	
		};
	}
}
