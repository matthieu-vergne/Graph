package fr.vergne.graph;

public interface Edge<CVertex> extends Hyperedge<CVertex> {

	CVertex getVertex1();

	CVertex getVertex2();
}
