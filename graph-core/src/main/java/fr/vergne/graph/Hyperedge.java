package fr.vergne.graph;

import java.util.Collection;

public interface Hyperedge<CVertex> {

	public Collection<CVertex> getVertices();

	public boolean hasSameVerticesThan(Hyperedge<?> r);

}
