package fr.vergne.graph.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

import fr.vergne.graph.Hyperedge;

public class ImmutableHyperedge<CVertex> implements Hyperedge<CVertex> {

	private final Collection<CVertex> vertices;

	public ImmutableHyperedge(Collection<CVertex> vertices) {
		this.vertices = Collections.unmodifiableSet(new LinkedHashSet<CVertex>(
				vertices));
	}

	public Collection<CVertex> getVertices() {
		return vertices;
	}

	public boolean hasSameVerticesThan(Hyperedge<?> r) {
		return getVertices().containsAll(r.getVertices())
				&& r.getVertices().containsAll(getVertices());
	}

	@Override
	public String toString() {
		return getVertices().toString();
	}
}
