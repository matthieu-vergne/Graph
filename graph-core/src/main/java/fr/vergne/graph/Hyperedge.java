package fr.vergne.graph;

import java.util.Collection;

public interface Hyperedge<VertexType> {

	public Collection<VertexType> getVertices();

	public boolean hasSameVerticesThan(Hyperedge<?> r);

}
